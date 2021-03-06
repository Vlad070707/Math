package com.example.mathwithfinik.ui.mainscreen

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mathwithfinik.MainScreenAdapter
import com.example.mathwithfinik.MenuItem
import com.example.mathwithfinik.R
import com.example.mathwithfinik.databinding.MainScreenFragmentBinding


class MainScreenFragment : Fragment() {

    companion object {
        fun newInstance() = MainScreenFragment()
    }

    private lateinit var viewModel: MainScreenViewModel
    lateinit var binding: MainScreenFragmentBinding
    private val items = ArrayList<MenuItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initArray()
        binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.mspRv.apply {
            items.add(
                MenuItem(resources.getDrawable(R.drawable.icon_plus_minus), "Додавання і віднімання"))
            items.add(
                MenuItem(resources.getDrawable(R.drawable.icon_divide), "Ділення"))
            items.add(
                MenuItem(resources.getDrawable(R.drawable.icon_multiply), "Множення"))
            items.add(
                MenuItem(resources.getDrawable(R.drawable.icon_zadachi), "Задачі"))
            items.add(
                MenuItem(resources.getDrawable(R.drawable.icon_shopping_cart), "Магазин"))
            items.add(
                MenuItem(resources.getDrawable(R.drawable.icon_world), "Надаштування"))
            layoutManager = GridLayoutManager(activity, 2,  LinearLayoutManager.HORIZONTAL, false)
            adapter = MainScreenAdapter(items)
        }
        binding.mspTvMoneyBalance.text = "0"
        activity?.let { FinikFirstSpeachDialog.showDialog(it) }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainScreenViewModel::class.java]
        // TODO: Use the ViewModel
    }

    private fun initArray() {
            }
}