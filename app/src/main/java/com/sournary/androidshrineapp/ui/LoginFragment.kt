package com.sournary.androidshrineapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sournary.androidshrineapp.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created in 9/16/19 by Sang
 * Description:
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        login_button.setOnClickListener {
            val password = password_text_input.text.toString()
            if (isPasswordValid(password)) {
                password_input_layout.error = null
                val action = LoginFragmentDirections.loginToMenu()
                findNavController().navigate(action)
            } else {
                password_input_layout.error = "Error"
            }
        }
        password_text_input.setOnKeyListener { _, _, _ ->
            val password = password_text_input.text.toString()
            if (isPasswordValid(password)) {
                password_input_layout.error = null
            }
            false
        }
    }

    private fun isPasswordValid(
        password: String?
    ): Boolean = password != null && password.length > 2
}
