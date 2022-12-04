package gui;

/**Imports**/
import formularios.EstudiosLab.*;
import formularios.Hospitales.*;
import formularios.Medicos.*;
import formularios.Pacientes.*;

import javax.swing.JDesktopPane;

/**Clase Escritorio**/
public class Escritorio extends JDesktopPane {
    /*Variables*/
    //Vetanas Formularios
    //Medicos
    private MedAltas fmAlt;
    private MedBajas fmBaj;
    private MedCambios fmCam;
    private MedConsultas fmCon;
    //Pacientes
    private PacAltas fpAlt;
    private PacBajas fpBaj;
    private PacCambios fpCam;
    private PacConsultas fpCon;
    //Hospitales
    private HosAltas fhAlt;
    private HosBajas fhBaj;
    private HosCambios fhCam;
    private HosConsultas fhCon;
    //Estudios Lab
    private EstAltas feAlt;
    private EstBajas feBaj;
    private EstCambios feCam;
    private EstConsultas feCon;

    //Gets
    //Medicos
    public MedAltas getFmAlt() {return fmAlt = new MedAltas();}
    public MedBajas getFmBaj() {return fmBaj = new MedBajas();}
    public MedCambios getFmCam() {return fmCam = new MedCambios();}
    public MedConsultas getFmCon() {return fmCon = new MedConsultas();}
    //Pacientes
    public PacAltas getFpAlt() {return fpAlt = new PacAltas();}
    public PacBajas getFpBaj() {return fpBaj = new PacBajas();}
    public PacCambios getFpCam() {return fpCam = new PacCambios();}
    public PacConsultas getFpCon() {return fpCon = new PacConsultas();}

    //Hospitales
    public HosAltas getFhAlt() {return fhAlt = new HosAltas();}
    public HosBajas getFhBaj() {return fhBaj = new HosBajas();}
    public HosCambios getFhCam() {return fhCam = new HosCambios();}
    public HosConsultas getFhCon() {return fhCon = new HosConsultas();}
    //Estudios Lab

    public EstAltas getFeAlt() {return feAlt = new EstAltas();}
    public EstBajas getFeBaj() {return feBaj = new EstBajas();}
    public EstCambios getFeCam() {return feCam = new EstCambios();}
    public EstConsultas getFeCon() {return feCon = new EstConsultas();}

    /*Metodos*/

    //Constructor
    public Escritorio(){
        setBounds(270,20,290,500);
    }
}
