import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Playground {

	public final static String APIKEY = "nk5k804lSSTCoCopvA6tc35V2zmgZaxJPFPCLALz";
	
	public final static void main(String[] args) throws Exception {
        
		/*
		CloseableHttpClient httpclient = HttpClients.createDefault();
		 
        try {
        	
        	// https://api.challonge.com/v1/tournaments.xml?api_key=nk5k804lSSTCoCopvA6tc35V2zmgZaxJPFPCLALz&state=in_progress
        	
        	//https://api.challonge.com/v1/tournaments/1056450.xml?include_participants=1&api_key=nk5k804lSSTCoCopvA6tc35V2zmgZaxJPFPCLALz
        	
        	//https://api.challonge.com/v1/tournaments/1056450/participants.xml?participant_id=1
        	
            HttpPost httppost = new HttpPost("https://api.challonge.com/v1/tournaments/1056450/participants.xml?participant_id=1&api_key=nk5k804lSSTCoCopvA6tc35V2zmgZaxJPFPCLALz");

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("participant[name]", "testingMan"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            
            System.out.println("Executing request " + httppost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httppost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
        
        */
		
		System.out.println("-----------------");
		
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("1","pp",3));
		
		players.add(new Player("1","Armada",2));
		
		players.add(new Player("1","mango",1));
		
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i));
		}
		
		System.out.println("-----------------");
		
		Collections.sort(players,new Comparator<Player>() 
				  {
		    public int compare(Player lhs, Player rhs) 
		    {
		      return lhs.seed - rhs.seed;
		    }
		 });
		
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i));
		}
		
    }

}
