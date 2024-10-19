package com.example.cameraalbumtest

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.composetutorial.databinding.ActivityCameraAlbumMainBinding
import java.io.File

class CameraAlbumMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraAlbumMainBinding
    lateinit var imageUri: Uri
    lateinit var outputImage: File
    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { success:Boolean ->
            if (success) {
                //将拍摄的照片显示出来
                val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
                binding.imageView.setImageBitmap(rotateIfRequired(bitmap))
            }
        }

    private val getContentLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri:Uri? ->
            if (uri!=null){
                val bitmap = getBitmapFromUri(uri)
                binding.imageView.setImageBitmap(bitmap)
            }
        }

    private fun getBitmapFromUri(uri: Uri) = contentResolver.openFileDescriptor(uri, "r")?.use {
        BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
    }

    private fun rotateIfRequired(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        val orientation =
            exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        return when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270)
            else -> bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.preRotate(degree.toFloat())
        val rotateBitmap =
            Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        bitmap.recycle()//将不再需要的Bitmap对象回收
        return rotateBitmap
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraAlbumMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.takePhotoBtn.setOnClickListener {
            //创建File对象，用于存储拍照后的照片
            outputImage = File(externalCacheDir, "output_image.jpg")
            if (outputImage.exists()) {
                outputImage.delete()
            }
            outputImage.createNewFile()
            imageUri = FileProvider.getUriForFile(
                this,
                "com.example.cameraalbumtest.fileprovider",
                outputImage
            )
            takePictureLauncher.launch(imageUri)
        }

        binding.fromAlbumBtn.setOnClickListener {
            getContentLauncher.launch("image/*")
        }
    }
}