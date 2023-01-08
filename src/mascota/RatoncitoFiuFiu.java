package mascota;

public class RatoncitoFiuFiu {
    //
    // La clase mascota.RatoncitoFiuFiu aun no tiene ningun atributo
    //
    private String nombre;
    private int edad;
    private int peso;
    private byte hambre;
    private byte suciedad;
    private byte salud;
    private byte energia;
    private int envejecimiento;
    private final int INFANCIA = 0;
    private final int ADULTEZ = 1;
    private final int VEJEZ = 2;
    private boolean dormido;
    private final int MUERTE = 12000;
    private int juego;

    public RatoncitoFiuFiu(String nombre, int peso, byte hambre, byte suciedad, byte salud, byte energia) {
        // Un objeto mascota.RatoncitoFiuFiu debería informar cuando nace...
        this.energia = energia;
        this.hambre = hambre;
        this.peso = peso;
        this.suciedad = suciedad;
        this.salud = salud;
        this.nombre = nombre;
        edad = 0;
        this.dormido = false;
    }

    public String estadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Peso: ").append(this.peso);
        sb.append("\nHambre: ").append(this.hambre);
        sb.append("\nSuciedad: ").append(this.suciedad);
        sb.append("\nSalud: ").append(this.salud);
        sb.append("\nEnergia: ").append(this.energia);
        return sb.toString();
    }

    public void limpiar(float esfuerzoHigienico) {
        this.suciedad -= esfuerzoHigienico;
        if (suciedad <= 0) {
            this.suciedad = 0;
        }
    }

    public int queTramoEdad() {

        if (edad <= 2500) {
            return INFANCIA;
        } else if (edad <= 8000) {
            return ADULTEZ;
        } else {
            return VEJEZ;
        }
    }

    public boolean estasDormido() {
        if (energia <= 15) {
            dormido = true;
        } else if (energia >= 75) {
            dormido = false;
        }
        return dormido;
    }

    public boolean estasEnfermo() {
        return salud <= 25;
    }

    public boolean estasSucio() {
        return suciedad >= 80;
    }

    public boolean estasMuerto() {
        return salud <= 0 || edad > MUERTE;
    }

    public boolean tienesHambre() {
        return hambre >= 7;
    }

    public boolean estasFeliz() {
        return !estasSucio() && !tienesHambre();
    }

    public void envejecer(int segundos) {
        this.edad += segundos;
        envejecimiento += segundos;
        if (envejecimiento > 5) {
            this.hambre += 1;
            if (hambre >= 10) {
                this.hambre = 10;
            }
            this.suciedad += 5;
            if (suciedad >= 100) {
                this.suciedad = 100;
            }
            this.salud -= 5;
            if (salud <= 0) {
                this.salud = 0;
            }
            this.energia -= 5;
            if (energia <= 0) {
                this.energia = 0;
            }
            if (energia <= 15) {
                dormido = true;
            } else if (energia >= 75) {
                dormido = false;
            }
            if (dormido) {
                aumentarEnergia(10);
            }
            envejecimiento = 0;
        }

    }

    public boolean tienesQuejas() {
        return !estasFeliz();
    }

    public void alimentar(float cantidadAlimento) {
        if (tienesHambre()) {
            aumentarSalud(cantidadAlimento);
        }
        this.hambre -= cantidadAlimento;
        if (hambre <= 0) {
            this.hambre = 0;
        }
        ganarPeso(cantidadAlimento);
        aumentarEnergia(cantidadAlimento);
    }

    public void curar(float cantidadMedicina) {

        aumentarSalud(cantidadMedicina);
    }

    private void ganarPeso(float cantidad) {
        if (!estasEnfermo()) {
            this.peso += cantidad;
        }
    }

    private void aumentarEnergia(float cantidad) {
        this.energia += cantidad;
        if (energia >= 100) {
            this.energia = 100;
        }
        if (energia <= 15) {
            dormido = true;
        } else if (energia >= 75) {
            dormido = false;
        }
    }
    private void aumentarSalud(float cantidad) {
        this.salud += cantidad;
        if (salud >= 100) {
            salud = 100;
        }
    }
    public boolean jugar (float cantidadDiversion){

    }
}