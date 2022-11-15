package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.R
import ni.edu.uca.infopegue.databinding.FragmentBienvenidoBinding

class BienvenidoFragment : Fragment() {
    private lateinit var binding: FragmentBienvenidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentBienvenidoBinding.inflate(layoutInflater)
            iniciar()
        return binding.root
    }

    private fun iniciar() {
            binding.btnCliente.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.PantallaLoginCliente)
            }
            binding.btnEmpresa.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.PantallaLoginEmpresa)
            }
    }
}