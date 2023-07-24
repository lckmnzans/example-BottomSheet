package com.simple.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btnShowBottomSheet: Button
    private lateinit var bottomSheet: BottomSheetDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowBottomSheet = findViewById(R.id.btn_show_bottom_sheet)
        btnShowBottomSheet.setOnClickListener {
            bottomSheet = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
            val btnClose = view.findViewById<Button>(R.id.btn_dismiss)

            bottomSheet.setCancelable(false)
            bottomSheet.setContentView(view)
            bottomSheet.show()

            btnClose.setOnClickListener {
                bottomSheet.dismiss()
            }
        }
    }
}