package com.geektech.lovecalculator.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.RetrofitService
import com.geektech.lovecalculator.databinding.FragmentHomeBinding
import com.geektech.lovecalculator.model.LoveModel
import com.geektech.taskmanager.key.Key
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().getLoveApi().getResultLove(
                    firstName = etFirstName.text.toString(),
                    secondName = etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val data = LoveModel(
                            response.body()?.firstName.toString(),
                            response.body()?.secondName.toString(),
                            response.body()?.percentage.toString(),
                            response.body()?.result.toString()
                        )
                        findNavController().navigate(R.id.resultFragment, bundleOf(Key.KEY_DATA to data))
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("aga", "onFailure: " + t.message)
                    }
                })
            }
        }
    }
}