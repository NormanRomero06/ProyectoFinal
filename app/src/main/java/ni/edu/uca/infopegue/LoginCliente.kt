package ni.edu.uca.infopegue

import android.app.Notification
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.doOnAttach
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.R
import ni.edu.uca.infopegue.databinding.FragmentLoginClienteBinding

class LoginCliente : Fragment() {
    private lateinit var binding: FragmentLoginClienteBinding
    val nombreClave: String = "1"
    val pwdClave: String = "1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentLoginClienteBinding.inflate(layoutInflater)
        iniciar()
        passOlvidad()

        return binding.root

    }

    private fun passOlvidad(){
        binding.tvRecuperar.setOnClickListener {
            Toast.makeText(context,"Clic",Toast.LENGTH_SHORT).show()
        }
    }


    private fun iniciar() {

        try {
            binding.btnIngresar.setOnClickListener {
                val nameTemp = binding.TfUsuario.editText?.text.toString()
                val pwdTemp: String = binding.TfPw.editText?.text.toString()

                if (nameTemp == nombreClave && pwdTemp == pwdClave) {
                    Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasCliente)
                } else {
                    Toast.makeText(this.context, "Datos erroneos", Toast.LENGTH_SHORT).show()
                }

            }
        } catch (ex: Exception){

        }
    }


}





