try {
	    JSONObject jsonObject = new JSONObject(_jsonData);
	    JSONArray valuesArray = jsonObject.getJSONArray("values");
	
	    // Clear existing data
	    uu.clear();
	
	    // Use a set to keep track of unique phone numbers
	    Set<String> uniquePhoneNumbers = new HashSet<>();
	
	    // Convert to list of maps
	    for (int i = 0; i < valuesArray.length(); i++) {
		        JSONObject item = valuesArray.getJSONObject(i);
		        JSONObject nameValuePairs = item.getJSONObject("nameValuePairs");
		
		        String phoneNumber = nameValuePairs.getString("PhoneNumber");
		
		        // Check if the phone number is unique before adding to the list
		        if (!uniquePhoneNumbers.contains(phoneNumber)) {
			            Map<String, Object> map = new HashMap<>();
			            map.put("PhoneNumber", phoneNumber);
			            map.put("Name", nameValuePairs.getString("Name"));
			
			            uu.add((HashMap<String, Object>) map);
			
			            // Add the phone number to the set to mark it as processed
			            uniquePhoneNumbers.add(phoneNumber);
			        }
		    }
	
	    // Notify the adapter that data has changed
	    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
	
} catch (Exception e) {
	    e.printStackTrace();
}
