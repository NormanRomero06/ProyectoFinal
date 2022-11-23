package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentCrudClienteBinding

class CrudCliente : Fragment() {
    private lateinit var binding: FragmentCrudClienteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudClienteBinding.inflate(layoutInflater)
        Guardar()
        Acciones()
        AccionClean()
        BorrarDatos()
        CargarDatos()
        return binding.root
    }

    private fun Guardar() {

            try {
                with(binding) {
                    btnGuardar.setOnClickListener {
                        val nombreF = etPrimerNombre.text.toString()
                        val nombreS = etSegundoNombre.text.toString()
                        val apellidoF = etPrimerApellido.text.toString()
                        val apellidoS = etSegundoApellido.text.toString()
                        val edad = etEdad.text.toString().toInt()
                        val profesion = etProfesion.text.toString()
                        val correoP = etCorreoPersonal.text.toString()
                        val descrip = etDescripPersonal.text.toString()
                        val Edad: Int

                        if(edad <= 17) {
                        Edad = edad
                        if (nombreF == "" || nombreS == "" || apellidoF == "" || Edad.toString() == "" || profesion == "" || correoP == "" || descrip == "") {
                            Toast.makeText(
                                context,
                                "Un campo esta vacio, y no se pudo guardar la Empresa",
                                Toast.LENGTH_LONG
                            ).show();

                        } else {
                            Toast.makeText(context, "Menor de edad ", Toast.LENGTH_SHORT).show()
                        }

                        } else {
                            preferShared.saveFnombre(nombreF)
                            preferShared.saveSnombre(nombreS)
                            preferShared.saveFapellido(apellidoF)
                            preferShared.saveSapellido(apellidoS)
                            preferShared.saveEdad(edad)
                            preferShared.saveProfesion(profesion)
                            preferShared.saveCorreo(correoP)
                            preferShared.saveDescripcion(descrip)
                            Toast.makeText(context, "Datos Guardados ", Toast.LENGTH_SHORT).show()
                            limpiar()
                        }
                    }
                }

            } catch (ex: Exception) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

            }
        }


    private fun AccionClean() {
        binding.btnLimpiar.setOnClickListener { limpiar() }
    }

    fun limpiar() {
        with(binding) {
            etPrimerNombre.setText("")
            etSegundoNombre.setText("")
            etPrimerApellido.setText("")
            etSegundoApellido.setText("")
            etEdad.setText("")
            etProfesion.setText("")
            etCorreoPersonal.setText("")
            etDescripPersonal.setText("")

        }
        Toast.makeText(this.context, "Campos limpios", Toast.LENGTH_SHORT).show()
    }

    private fun BorrarDatos() {
        binding.btnEliminar.setOnClickListener {
            with(binding) {
                preferShared.RemoveNombre(etPrimerNombre.text.toString())
                preferShared.RemoveNombre2(etSegundoNombre.text.toString())
                preferShared.RemoveApellido(etPrimerApellido.text.toString())
                preferShared.RemoveApellido2(etSegundoApellido.text.toString())
                preferShared.RemoveEdad(etEdad.text.toString().toInt())
                preferShared.RemoveProfesion(etProfesion.text.toString())
                preferShared.RemoveCorreo(etCorreoPersonal.text.toString())
                preferShared.RemoveDescripcion(etDescripPersonal.text.toString())

            }
            Toast.makeText(this.context, "Datos Borrados", Toast.LENGTH_SHORT).show()
            limpiar()

        }
    }

    private fun CargarDatos() {
        with(binding) {
            etPrimerNombre.setText(preferShared.getFnombre())
            etSegundoNombre.setText(preferShared.getSnombre())
            etPrimerApellido.setText(preferShared.getFapellido())
            etSegundoApellido.setText(preferShared.getSapellido())
            etEdad.setText(preferShared.getEdad().toString())
            etProfesion.setText(preferShared.getProfesion())
            etCorreoPersonal.setText(preferShared.getCorreo())
            etDescripPersonal.setText(preferShared.getDescripcion())
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
            Navigation.findNavController(binding.root).navigate(R.id.PantallaSolicitudesCliente)
        }
    }
}