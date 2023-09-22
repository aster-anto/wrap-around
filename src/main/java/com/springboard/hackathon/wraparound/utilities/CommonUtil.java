package com.springboard.hackathon.wraparound.utilities;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;	

/**
 * common utility class
 */
public class CommonUtil {

	/**
	 * returns awsSecret
	 * @param secretName
	 * @return
	 */
	public static String getAwsSecret(String secretName) {

	    //String secretName = "notification-service-secrets";
	    Region region = Region.of("us-east-1");

	    // Create a Secrets Manager client
	    SecretsManagerClient client = SecretsManagerClient.builder()
	            .region(region)
	            .build();

	    GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
	            .secretId(secretName)
	            .build();

	    GetSecretValueResponse getSecretValueResponse;

	    try {
	        getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
	    } catch (Exception e) {
	        throw e;
	    }

	    return getSecretValueResponse.secretString();
	}
	
}
