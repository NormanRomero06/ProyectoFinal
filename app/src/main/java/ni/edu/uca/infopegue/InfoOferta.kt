package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentInfoOfertaBinding
import ni.edu.uca.infopegue.entidades.Oferta

class InfoOferta : Fragment(){
    private lateinit var binding: FragmentInfoOfertaBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInfoOfertaBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        return binding.root
    }

    private fun iniciar() {
        var arreglo = ShareObjectAdp.preferShared.getArray()
        var tempKey = ShareObjectAdp.preferShared.getTempKey()
        var list = arrayListOf<Oferta>()
        //var key = ShareObjectAdp.preferShared.getKey(tempKey)



        with(binding) {
            etNombreOferta.setText(ShareObjectAdp.preferShared.getNombreOf(tempKey))
            etContacto.setText(ShareObjectAdp.preferShared.getContactoOf(tempKey))
            etRequisitos.setText(ShareObjectAdp.preferShared.getRequisitoOf(tempKey))
            etUbicacion.setText(ShareObjectAdp.preferShared.getUbicacionOf(tempKey))
            etDescripOferta.setText(ShareObjectAdp.preferShared.getDescripcionOf(tempKey))


        }

                }








    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosCliente)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasCliente)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }
    }
}