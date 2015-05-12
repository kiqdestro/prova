package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Complexo {
    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        this.real = real;
        this.img = img;
    }
    
    public double getReal() {
        return real;
    }
    public double getImg () {
        return img;
    }
    
    public Complexo soma(Complexo c) {
        return new Complexo(real + c.real, img + c.img);
    }
    
    public Complexo sub(Complexo c) {
        return new Complexo(real - c.real, img - c.img);
    }
    
    public Complexo prod(double r) {
        return new Complexo(r*real,r*img);
    }
    
    public Complexo prod(Complexo c) {
        return new Complexo((real*c.real)-(img*c.img), (img*c.real)+(real*c.img));
    }
    
    public Complexo div(Complexo c) {
        Complexo r = new Complexo(((real*c.real)+(img*c.img))/(Math.pow(c.real, 2)+Math.pow(c.img, 2)), ((img*c.real)-(real*c.img))/(Math.pow(c.real, 2)+Math.pow(c.img, 2)));
        return r;
    }
    
    public Complexo[] sqrt() {
        double p = Math.sqrt(Math.sqrt(Math.pow(real, 2)+Math.pow(img, 2)));
        double v1 = p/2;
        double v2 = (p/2)+Math.PI;
        Complexo[] r = {new Complexo(p*(Math.cos(v1)),p*(Math.sin(v1))), new Complexo(p*(Math.cos(v2)),p*(Math.sin(v2)))};
        return r;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(real)
            ^ (Double.doubleToLongBits(real) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(img)
            ^ (Double.doubleToLongBits(img) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
            && real == c.real && img == c.img;
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", real, img);
    }
}
