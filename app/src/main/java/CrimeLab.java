import android.content.Context;

/**
 * Created by Drake on 3/20/2017.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private CrimeLab(Context context){

    }

    public static CrimeLab get(Context context){
        if(sCrimeLab==null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
}
