package com.freshplanet.ane.AirFacebook.functions;

import android.content.Intent;
import android.net.Uri;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.freshplanet.ane.AirFacebook.AirFacebookExtension;

public class GoToPageFunction implements FREFunction {

	@Override
	public FREObject call(FREContext arg0, FREObject[] arg1) {
		
		String page = null;
		
		try {
			page = arg1[0].getAsString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			e.printStackTrace();
		}
		
		if (page != null)
		{
			try{
				AirFacebookExtension.log("opening page fb://page/" + page);
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/"+page)); 
				arg0.getActivity().startActivity(intent);
			} catch(Exception e) {
				AirFacebookExtension.log("opening page http://facebook.com/" + page);
				arg0.getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/"+page)));
			}
		} else {
			AirFacebookExtension.log("page is null");
		}
		
		return null;
	}

}
