try {
	    JSONObject jsonObject = new JSONObject(_jsonData);
	    JSONArray valuesArray = jsonObject.getJSONArray("values");
	
	    // Clear existing data
	    uu.clear();
	
	    // Convert to list of maps in reverse order
	    for (int i = valuesArray.length() - 1; i >= 0; i--) {
		        JSONObject item = valuesArray.getJSONObject(i);
		        JSONObject nameValuePairs = item.getJSONObject("nameValuePairs");
		
		        Map<String, Object> map = new HashMap<>();
		        map.put("PhoneNumber", nameValuePairs.getString("PhoneNumber"));
		
		        // Check if CallerName exists, set to "Not Available" if not
		        if (nameValuePairs.has("CallerName")) {
			            map.put("CallerName", nameValuePairs.getString("CallerName"));
			        } else {
			            map.put("CallerName", "Not Available");
			        }
		
		        map.put("CallDate", nameValuePairs.getString("CallDate"));
		        map.put("CallType", nameValuePairs.getString("CallType"));
		        map.put("CallDuration", nameValuePairs.getString("CallDuration"));
		
		        uu.add((HashMap<String, Object>) map);
		    }
	
	    // Notify the adapter that data has changed
	    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
	
} catch (Exception e) {
	    e.printStackTrace();
}
