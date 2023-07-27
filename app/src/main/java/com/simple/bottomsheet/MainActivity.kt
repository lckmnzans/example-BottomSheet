package com.simple.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btnShowBottomSheetModal: Button
    private lateinit var btnShowBottomSheetPersist: Button
    private lateinit var bottomSheetModal: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowBottomSheetModal = findViewById(R.id.btn_show_bottom_sheet_modal)
        btnShowBottomSheetPersist = findViewById(R.id.btn_show_bottom_sheet_persist)
        bottomSheetModal = BottomSheetDialog(this)

        btnShowBottomSheetModal.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet_modal, null)
            val btnDismiss = view.findViewById<Button>(R.id.btn_dismiss)

            bottomSheetModal.setCancelable(false)
            bottomSheetModal.setContentView(view)
            bottomSheetModal.show()

            btnDismiss.setOnClickListener {
                bottomSheetModal.dismiss()
            }
        }

        val bottomSheet: View = findViewById(R.id.bottom_sheet)
        val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheet)
        /*
        * state in BottomSheetPersist
        * - if BottomSheet state is hidden, it can only be expanded programmatically not by using slide up gesture
        * - the BottomSheet hidden state can only be set by setting behavior_hideable to true
        * */
        bottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        btnShowBottomSheetPersist.setOnClickListener {
                            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                        }
                    }
                    else -> {
                        btnShowBottomSheetPersist.setOnClickListener {
                            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                        }
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //
            }
        })


    }
}