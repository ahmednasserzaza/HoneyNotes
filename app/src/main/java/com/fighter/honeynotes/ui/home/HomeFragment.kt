package com.fighter.honeynotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fighter.honeynotes.databinding.FragmentAddNoteBinding
import com.fighter.honeynotes.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {
    private lateinit var bottomSheet: BottomSheetDialog
    private lateinit var addNoteBinding: FragmentAddNoteBinding
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAddNote.setOnClickListener {
            initiateBottomSheet()
        }

    }

    private fun initiateBottomSheet() {
        bottomSheet = BottomSheetDialog(requireContext())
        addNoteBinding = FragmentAddNoteBinding.inflate(layoutInflater)
        bottomSheet.setContentView(addNoteBinding.root)
        bottomSheet.show()
    }

}