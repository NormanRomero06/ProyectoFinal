package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentDatosEmpresaBinding


class DatosEmpresa : Fragment() {
    private lateinit var binding: FragmentDatosEmpresaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDatosEmpresaBinding.inflate(layoutInflater)
        iniciar()
        Botones()
        return binding.root
    }

    private fun iniciar() {
        with(binding) {
            var NombreEmp = ShareObjectAdp.preferShared.getNombre()
            tvNombreEmpresa.text = NombreEmp

            var DireccionEmp = ShareObjectAdp.preferShared.getDireccion()
            tvDirecEmpresa.text = DireccionEmp

            var Repre = ShareObjectAdp.preferShared.getRepresentante()
            tvJefeEmpresa.text = Repre

            var Contacto = ShareObjectAdp.preferShared.getContacto()
            tvContacto.text = Contacto

            var CorreoEmp = ShareObjectAdp.preferShared.getCorreoEmp()
            tvCorreoEmpresa.text = CorreoEmp

            var DescripcionEmp = ShareObjectAdp.preferShared.getDescripcionEmp()
            tvDescripEmpresa.text = DescripcionEmp
        }
    }

    private fun Botones() {
        binding.IvAtras.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }
        binding.ivEditar.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaCrudEmpresa)
        }
    }
}