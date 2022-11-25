package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentLoginEmpresaBinding


class LoginEmpresa : Fragment() {
    private lateinit var binding: FragmentLoginEmpresaBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginEmpresaBinding.inflate(layoutInflater)
        iniciar()
        passOlvidad()
        return binding.root
    }
    private fun passOlvidad(){

        binding.tvNewCuenta.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaCreacionEmpresa)
        }
        binding.tvRecuperar.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.recuperarpw)

        }
    }


    private fun iniciar() {


        try {
            binding.btnIngresar.setOnClickListener {
                val nameTemp: String = binding.TfUsuario.editText?.text.toString()
                val pwdTemp: String = binding.TfPw.editText?.text.toString()

                if (nameTemp == preferShared.getUserE() && pwdTemp == preferShared.getPassE()) {
                    Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
                } else {
                    Toast.makeText(this.context, "Datos erroneos", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (ex: Exception) {

        }
    }
}