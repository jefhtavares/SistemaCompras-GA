import java.util.GregorianCalendar;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(){
        GregorianCalendar c = new GregorianCalendar();
        dia = c.get(GregorianCalendar.DAY_OF_MONTH);
        mes = c.get(GregorianCalendar.MONTH) + 1;
        ano = c.get(GregorianCalendar.YEAR);
    }

    public Data(int d, int m, int a) {
        dia = d;
        mes = m;
        ano = a;
    }

    @Override
    public boolean equals(Object other){
        Data outraData = (Data)other;
        return this.getTicks() == outraData.getTicks();
    }

    public boolean eMaiorQue(Data outra){
        return this.getTicks() > outra.getTicks();
    }

    private int getTicks(){
        int diasAno = this.ano * (this.eBissexto() ? 366 : 365);
        int diasMes = this.mes * this.diasDoMes();

        return diasAno + diasMes + this.dia;
    }

    public String obtemDataPadrao() {
        return dia + "/" + mes + "/" + ano;
    }

    public String obtemDataPadraoComZeros() {
        if (dia >= 10 && mes >= 10)
            return obtemDataPadrao();
        else{
            String d = String.valueOf(dia);
            if (dia < 10)
                d = "0" + dia;

            String m = String.valueOf(mes);

            if (mes < 10)
                m = "0" + mes;

            return d + "/" + m + "/" + ano;
        }
    }

    public int obtemDataInvertida() {
        return ano * 10000 + mes * 100 + dia;
    }

    public void setDia(int d){
        dia = d;
    }

    public void setMes(int m){
        mes = m;
    }

    public void setAno(int a){
        ano = a;
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    public void leData() {
        Teclado t = new Teclado();
        int data = t.leInt();
        ano = data / 10000;
        mes = (data - ano * 10000) / 100;
        dia = data - ano * 10000 - mes * 100;
    }

    public boolean eBissexto(){
        return eBissexto(this.ano);
    }

    public static boolean eBissexto(int ano){
        if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0))
            return true;
        else
            return false;
    }

    public int diasDoMes(){
        return diasDoMes(this.mes, this.ano);
    }

    public static int diasDoMes(int mes, int ano){
        if (mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes ==12)
            return 31;
        else if (mes == 2) {
            if (eBissexto(ano))
                return 29;
            else
                return 28;
        }
        else
            return 30;
    }

    public int diasDeOutraData(Data outra) {
        Data max, min;
        if (this.obtemDataInvertida() > outra.obtemDataInvertida()){
            max = this;
            min = outra;
        }
        else{
            max = outra;
            min = this;
        }

        int dias = 0;
        if (max.ano == min.ano)
            if (max.mes == min.mes)
                if (max.dia == min.dia)//mesmo dia
                    dias = 0;
                    else
                        dias = max.dia - min.dia;//mesmo mes, dias dif
            else {
                dias = diasDoMes(min.mes, min.ano) - min.dia;

                for (int i = min.mes+1; i<max.mes; i++)
                    dias += diasDoMes(i, min.ano);

               dias += max.dia;
            }
        else{
            for (int i=min.ano + 1; i<max.ano; i++)
                if (eBissexto(i))
                    dias += 366;
                else
                    dias += 365;

             dias += diasDoMes(min.mes, min.ano) - min.dia;

             for (int i = min.mes+1; i<=12; i++)
                   dias += diasDoMes(i, min.ano);

             for (int i = 1; i < max.mes; i++)
                 dias += diasDoMes(i, max.ano);
             dias += max.dia;
            }
        return dias;
    }
}
