package com.mtbc.mvvmwithflow.slidingNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.mtbc.mvvmwithflow.R


class CenteredTextFragment : Fragment() {

    companion object {
        private const val EXTRA_TEXT = "text"

        fun createFor(text: String): CenteredTextFragment {
            val fragment = CenteredTextFragment()
            val args = Bundle().apply {
                putString(EXTRA_TEXT, text)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_centered_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString(EXTRA_TEXT) ?: ""
        val textView: TextView = view.findViewById(R.id.text)
        textView.text = text
        textView.setOnClickListener {
            Toast.makeText(it.context, text, Toast.LENGTH_SHORT).show()
        }
    }
}
