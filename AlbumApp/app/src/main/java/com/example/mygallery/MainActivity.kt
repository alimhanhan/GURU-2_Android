package com.example.mygallery

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import android.Manifest
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val REQUEST_READ_EXTERNAL_STORAGE = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //권한이 부여되었는지 확인
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)

            //권한이 허용되지 않았을 경우
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)){
                //일전에 거부한 적이 있다면 설명
                var dlg = AlertDialog.Builder(this)
                dlg.setTitle("권한이 필요한 이유")
                dlg.setMessage("사진 정보를 얻기 위해서는 외부 저장소 권한이 필수로 요구됩니다.")
                dlg.setPositiveButton("확인"){dialog, which -> ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_READ_EXTERNAL_STORAGE)}
                dlg.setNegativeButton("취소",null)
                dlg.show()
            }
            else{
                //처음으로 권한 요청
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_READ_EXTERNAL_STORAGE) }
            else {//권한이 제대로 허용됨
                getAllPhotos()
            }
    }

    private fun getAllPhotos() {
        //모든 사진 정보 가져오기
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        null, //가져올 항목 배열
            null, //조건
            null,  //조건
        MediaStore.Images.ImageColumns.DATE_TAKEN+ " DESC") //촬영일 내림차순
        if(cursor != null){
            while (cursor.moveToNext()){
                //사진 경로 uri 가져오기
                val uri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                Log.d("MainActivity", uri)
            }
            cursor.close()
        }

    }
}