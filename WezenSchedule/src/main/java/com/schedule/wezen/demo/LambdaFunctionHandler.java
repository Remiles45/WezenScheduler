package com.schedule.wezen.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaFunctionHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

        // TODO: Implement your stream handler. See https://docs.aws.amazon.com/lambda/latest/dg/java-handler-io-type-stream.html for more information.
        // This demo implementation capitalizes the characters from the input stream.
        int letter = 0;
        while((letter = input.read()) >= 0) {
            output.write(Character.toUpperCase(letter));
        }
    }

}


/**
    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        
		LambdaLogger logger = context.getLogger();
		logger.log("Loading Java Lambda handler of RequestStreamHandler");
		
		// This is the header for all the JSON code
		JSONObject headerJson = new JSONObject();
		headerJson.put("Content-Type",  "application/json");  // not sure if needed anymore?
		headerJson.put("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
	    headerJson.put("Access-Control-Allow-Origin",  "*");
	    
	    // This is the actual JSON response object
		JSONObject responseJson = new JSONObject();
		responseJson.put("headers", headerJson);

		// This is the object where the 200 or 400 codes will be stored
		AddResponse response = null;
		
		// extract body from incoming HTTP POST request. If any error, then return 422 error
		// The InputStream object "input" (parameter) is the request
		String body;
		boolean processed = false;
		try {
			// The input request gets turned into a JSON object
			BufferedReader reader = new BufferedReader(new InputStreamReader(input)); // Reads the input
			JSONParser parser = new JSONParser(); // creates a JSON parser, will convert input into JSON code
			JSONObject event = (JSONObject) parser.parse(reader); // This JSON object will hold the converted value of the input
			logger.log("event:" + event.toJSONString()); // logs the request
			
			// Determines what kind of method the request is (get, body, options)
			String method = (String) event.get("httpMethod"); // turns the method into a string
			if (method != null && method.equalsIgnoreCase("OPTIONS")) { // if the method is OPTIONS...
				logger.log("Options request"); // log it as an OPTIONS request
				response = new AddResponse(0, 200);  // OPTIONS needs a 200 response
				// responseJson is the object created earlier to hold the JSON response
		        responseJson.put("body", new Gson().toJson(response)); // puts the 200 response into the JSON body
		        processed = true; // tell the program the response has been processed
		        body = null;
			} else { // If the request is a get or body
				body = (String)event.get("body");
				if (body == null) {
					body = event.toJSONString();  // this is only here to make testing easier
				}
			}
			// if the input couldn't be processed
		} catch (ParseException pe) {
			logger.log(pe.toString());
			response = new AddResponse(0, 422);  // Send a 422 code (unable to process input)
	        responseJson.put("body", new Gson().toJson(response));
	        processed = true;
	        body = null;
		}
		
		// If the request is a body or a get request
		if (!processed) {
			AddRequest req = new Gson().fromJson(body, AddRequest.class); // create a new AddRequest
			logger.log(req.toString()); // log request

			double val1 = 0.0; // variable to store 1st add argument
			try {
				val1 = Double.parseDouble(req.arg1); // parse the 1st argument and store in val1 variable
			} catch (NumberFormatException e) { // If the 1st argument couldn't be parsed, its probably a constant
				val1 = loadConstant(req.arg1); // search for constant and give val1 the value of the constant
			}

			double val2 = 0.0; // variable to store 2nd argument
			try {
				val2 = Double.parseDouble(req.arg2); // parse 2nd argument and store value in val2 variable
			} catch (NumberFormatException e) { // If the argument couldn't be parsed, probably a constant 
				val2 = loadConstant(req.arg2); // search for constant and give val2 the value of that constant
			}

			// compute proper response
			AddResponse resp = new AddResponse(val1 + val2, 200); // Add the two values, store them in a new add response with a 200 code
	        responseJson.put("body", new Gson().toJson(resp)); // put it in responseJson 
		}
		
        logger.log("end result:" + responseJson.toJSONString()); // log that the process is finished
        logger.log(responseJson.toJSONString()); // log responseJson
        OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8"); // create an OutputStreamWriter object
        writer.write(responseJson.toJSONString()); // write the response and send it out
        writer.close(); // close

    }*/