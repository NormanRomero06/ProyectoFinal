package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentNuevoUsuarioBinding

class CreacionUsuario : Fragment() {
    private lateinit var binding: FragmentNuevoUsuarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNuevoUsuarioBinding.inflate(layoutInflater)
        guardar()

        return binding.root
    }

    private fun  guardar(){
        binding.btnNew.setOnClickListener {
            ShareObjectAdp.preferShared.saveUser(binding.TfUsuario.editText?.text.toString())
            ShareObjectAdp.preferShared.savePass(binding.TfPwNew.editText?.text.toString())
            ShareObjectAdp.preferShared.saveCorreo(binding.TfCorreo.editText?.text.toString())
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(binding.root).navigate(R.id.PantallaBienvenido)
        }
    }

}