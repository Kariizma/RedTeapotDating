package com.example.redteapotdating.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.redteapotdating.R
import com.example.redteapotdating.databinding.FragmentDatingBinding
import com.example.redteapotdating.models.Users
import com.example.redteapotdating.viewmodels.DatingViewModel

class DatingFragment: Fragment() {

    private val viewModel: DatingViewModel by activityViewModels()
    private var binding: FragmentDatingBinding? = null
    private var localList: MutableList<Users> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDatingBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel
        binding?.datingFragment = this
        binding?.lifecycleOwner = this

        //observing livedata of the user list in the fragment
        viewModel.users.observe(viewLifecycleOwner){
            localList.addAll(it)
            displayUsers(0)
        }
        //observing the livedata of the counter
        viewModel.counter.observe(viewLifecycleOwner) {
            if (it == localList.size && it != 0)
                Toast.makeText(context, R.string.no_users_left, LENGTH_LONG).show()
            else
                displayUsers(it)
            Log.v("counter", it.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun displayUsers(index: Int)
    {
        //name
        binding!!.name.text = localList.getOrNull(index)?.name
        if(localList.getOrNull(index)?.name != null) {
            binding!!.name.visibility = View.VISIBLE
            binding!!.name.text = localList.getOrNull(index)?.name
        }
        else {
            binding!!.name.visibility = View.GONE
        }


        //photo
        if(localList.getOrNull(index)?.photo != null) {
            binding!!.image.visibility = View.VISIBLE
            binding!!.image.load(localList.getOrNull(index)?.photo)
        }
        else
        {
            binding!!.image.visibility = View.GONE
        }

        //gender
        if(localList.getOrNull(index)?.gender != null) {
            binding!!.genderLayout.visibility = View.VISIBLE
            if(localList.getOrNull(index)?.gender.equals("m"))
                binding!!.genderIdentity.text = "Male"
            else
                binding!!.genderIdentity.text = "Female"
        }
        else {
            binding!!.genderLayout.visibility = View.GONE
        }


        //about
        if(localList.getOrNull(index)?.about != null) {
            binding!!.aboutLayout.visibility = View.VISIBLE
            binding!!.AboutMe.text = localList.getOrNull(index)?.about
        }
        else
            binding!!.aboutLayout.visibility = View.GONE

        //school
        if(localList.getOrNull(index)?.school != null) {
            binding!!.schoolLayout.visibility = View.VISIBLE
            binding!!.schoolName.text = localList.getOrNull(index)?.school
        }
        else
            binding!!.schoolLayout.visibility = View.GONE

        //hobbies
        if(localList.getOrNull(index)?.hobbies != null) {
            binding!!.hobbiesLayout.visibility = View.VISIBLE
            binding!!.hobbiesList.text = localList.getOrNull(index)?.hobbies?.joinToString(",")
        }
        else
            binding!!.hobbiesLayout.visibility = View.GONE

    }
}