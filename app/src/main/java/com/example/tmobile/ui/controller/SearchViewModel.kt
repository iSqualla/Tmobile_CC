package com.example.tmobile.ui.controller

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.tmobile.R
import com.example.tmobile.common.TextWatcherWrapper
import com.example.tmobile.data.SearchResponseItem
import com.example.tmobile.databinding.FragmentSearchBinding
import com.google.android.material.internal.TextWatcherAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel
@Inject constructor(
    private val mainRepository: MainRepositoryImpl
) : ViewModel() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    var onInit = false
    var searchString: String = "mojo"

    private val _list = MutableLiveData<List<SearchResponseItem>>()
    val list: LiveData<List<SearchResponseItem>>
        get() = _list

    private val _user = MutableLiveData<SearchResponseItem>()
    val user: LiveData<SearchResponseItem>
        get() = _user



    fun setBinding(binding: FragmentSearchBinding) {
        _binding = binding
        setListener()
    }

    private fun setListener(){
        binding.etSearch.addTextChangedListener(object : TextWatcherWrapper() {
            override fun afterTextChanged(p0: Editable?) {
                searchUser(p0.toString())
            }
        })
    }

    init {
        fetchList()
    }

    fun fetchList() {
        viewModelScope.launch {
            mainRepository.fetchData().let {
                _list.postValue(it)
            }
        }
    }

    fun searchUser(user: String){
        if(!onInit) {
            viewModelScope.launch {
//                mainRepository.searchUser(user).let {
//                    _list.postValue(it)
//                }
            }
        }
        else{ onInit = true }
    }

    fun fetchUser(user: String) {
        viewModelScope.launch {
            mainRepository.fetchUser(user).let {
                _user.postValue(it)
            }
        }
    }

    fun onUserClick(user:String){
        findNavController(binding.root).navigate(R.id.action_searchFragment_to_userFragment, null)
        fetchUser(user)
    }
}