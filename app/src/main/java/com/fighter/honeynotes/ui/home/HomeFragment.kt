package com.fighter.honeynotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.fighter.honeynotes.databinding.FragmentAddNoteBinding
import com.fighter.honeynotes.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment() {
    private lateinit var bottomSheet: BottomSheetDialog
    private lateinit var addNoteBinding: FragmentAddNoteBinding
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

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

        initiateBottomSheet()
        addCallBacks()
        initiateViewModel()

        val adapter = NotesAdapter(emptyList())
        binding.recyclerNotes.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner){
            adapter.setItems(it)
            bottomSheet.dismiss()
        }

    }

    private fun initiateViewModel() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun addCallBacks() {
        binding.fabAddNote.setOnClickListener {
            bottomSheet.show()
        }
    }

    private fun initiateBottomSheet() {
        bottomSheet = BottomSheetDialog(requireContext())
        addNoteBinding = FragmentAddNoteBinding.inflate(layoutInflater)
        addNoteBinding.viewModel = viewModel
        addNoteBinding.lifecycleOwner = this
        bottomSheet.setContentView(addNoteBinding.root)
    }

}