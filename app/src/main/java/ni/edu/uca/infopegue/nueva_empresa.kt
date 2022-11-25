package ni.edu.uca.infopegue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentNuevaEmpresaBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class nueva_empresa : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentNuevaEmpresaBinding

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
        binding = FragmentNuevaEmpresaBinding.inflate(layoutInflater)
        guardar()
        return binding.root
    }

    private fun guardar() {
        binding.btnNewEm.setOnClickListener {
            ShareObjectAdp.preferShared.saveUserE(binding.TfUsuario.editText?.text.toString())
            ShareObjectAdp.preferShared.savePassE(binding.TfPwNew.editText?.text.toString())
            ShareObjectAdp.preferShared.saveCorreoEm(binding.TfCorreo.editText?.text.toString())
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(binding.root).navigate(R.id.PantallaBienvenido)

        }
    }
    companion object {
        fun newInstance(param1: String, param2: String) =
            nueva_empresa().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}