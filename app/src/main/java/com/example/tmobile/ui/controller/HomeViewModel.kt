package com.example.tmobile.ui.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.tmobile.R
import com.example.tmobile.data.SearchResponseItem
import com.example.tmobile.databinding.FragmentHomeBinding
import com.example.tmobile.databinding.FragmentSearchBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val _list = MutableLiveData<List<SearchResponseItem>>()
    val list: LiveData<List<SearchResponseItem>>
        get() = _list

    val str: String = "LALALALALLA"

    fun setBinding(binding: FragmentHomeBinding) {
        _binding = binding
    }

    fun goToList() {
        findNavController(binding.root).navigate(R.id.action_homeFragment_to_searchFragment, null)
    }


}