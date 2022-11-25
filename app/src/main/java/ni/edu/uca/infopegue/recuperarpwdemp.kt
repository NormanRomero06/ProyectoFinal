package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentRecuperarpwdempBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class recuperarpwdemp : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentRecuperarpwdempBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecuperarpwdempBinding.inflate(layoutInflater)
        validacion()
        return binding.root

    }

    private fun validacion() {
        try {
            with(binding) {
                btnCambiar.setOnClickListener {
                    val Correo = TfCorreo.editText?.text.toString()
                    val Usuario = TfUsuario.editText?.text.toString()
                    val NewPass = TfPwNew.editText?.text.toString()

                    if (NewPass == "") {
                        Toast.makeText(context, "Ingrese Nueva pass", Toast.LENGTH_SHORT)
                            .show()
                    } else {

                        if (ShareObjectAdp.preferShared.getUserE() == Usuario && ShareObjectAdp.preferShared.getCorreoEmp() == Correo) {
                            ShareObjectAdp.preferShared.RemovePassE()
                            ShareObjectAdp.preferShared.savePassE(NewPass)
                            Toast.makeText(context, "Nueva Pass guardada", Toast.LENGTH_SHORT)
                                .show()
                            Navigation.findNavController(binding.root)
                                .navigate(R.id.PantallaLoginEmpresa)

                        } else {
                            Toast.makeText(
                                context,
                                "Datos no encontrados, intente otra vez",
                                Toast.LENGTH_SHORT
                            )
                                .show()

                        }
                    }
                }
            }

        } catch (ex: Exception) {
        }
    }


    companion object {

        fun newInstance(param1: String, param2: String) =
            recuperarpw().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
