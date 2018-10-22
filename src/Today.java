import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Today
{
    //класс с текущей датой и операциями над ней
    public String getDate()
    {
        //возвращает строкой текущую дату в формате: ГГГГММДД_ЧЧммСС
        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        StringBuffer sb = new StringBuffer();
        sb.append(format.format(new Date()));
        return sb.toString();
    }
}
