package bestoffer.kau.edu.bestoffer;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by user on 25/03/18.
 */

public class mangecart extends AsyncTask<String, Void, String> {
    private Context context ;
    private int i;
    private items item;
    public mangecart(Context context , items item , int i) {
        this.context = context ;
        this.item = item ;
        this.i = i ;
    }

    @Override
    protected String doInBackground(String... args) {


        String link;

        BufferedReader bufferedReader;
        String result;

        try {

            User user = User.getInstance();

            link = "http://bestoffer.gwiddle.co.uk/mangecart.php?i="+i+"&email=" + user.getEmail()+"&id="+item.getId()+"&supermarket="+item.getSupermarket().toUpperCase();
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String query_result = jsonObj.getString("query_result");
                if (query_result.equals("SUCCESS")) {

                    if ( i==1){
                        Toast.makeText(context, "item inserted", Toast.LENGTH_SHORT).show();
                        cart.cartList.add(item);

                    }else if (i == 2){
                        Toast.makeText(context, "item deleted", Toast.LENGTH_SHORT).show();
                        cart.cartList.remove(item) ;
                    }

                } else if (query_result.equals("FAILURE")) {
                    Toast.makeText(context, "there is something wrong please try again later", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context, "check your internet connection Please.", Toast.LENGTH_SHORT).show();
                System.out.println(e.getMessage());
            }
        } else {
            Toast.makeText(context, "Somthing went wrong Please try again later.", Toast.LENGTH_SHORT).show();
        }
    }

}
