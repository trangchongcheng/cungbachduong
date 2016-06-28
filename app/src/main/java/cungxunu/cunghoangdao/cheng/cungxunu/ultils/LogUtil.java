package cungxunu.cunghoangdao.cheng.cungxunu.ultils;

import android.util.Log;

import cungxunu.cunghoangdao.cheng.cungxunu.BuildConfig;


public class LogUtil {

	public static final String LOG_TAG_BASE = "moremall1.";
	//--------------------------------------------------------------------------------------------------------------------
	/**
	 * Send a {@link #DEBUG} log message.
	 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
	 * @param message The message you would like logged.
	 */
	public static void d(String tag, String message) {
		if(BuildConfig.DEBUG) {
			tag = LOG_TAG_BASE + tag + "." + getMethodName();
			Log.d(tag, message);
		}
	}
	//--------------------------------------------------------------------------------------------------------------------
	/**
	 * Send a {@link #DEBUG} log message and log the exception.
	 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
	 * @param message The message you would like logged.
	 * @param throwable An exception to log
	 */
	public static void d(String tag, String message, Throwable throwable) {
		if(BuildConfig.DEBUG) {
			tag = LOG_TAG_BASE + tag + "." + getMethodName();
			Log.d(tag, message, throwable);
		}
	}
	//--------------------------------------------------------------------------------------------------------------------
	/**
	 * Send an {@link #ERROR} log message.
	 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
	 * @param message The message you would like logged.
	 */
	public static void e(String tag, String message) {
		if(BuildConfig.DEBUG) {
			tag = LOG_TAG_BASE + tag + "." + getMethodName();
			Log.e(tag, message);
		}
	}

	//--------------------------------------------------------------------------------------------------------------------

	public static void json(String tag, String json) {
		if(BuildConfig.DEBUG) {
			tag = LOG_TAG_BASE + tag + "." + getMethodName() + "\\n" + json;
			System.out.println(tag);
		}
	}
	//--------------------------------------------------------------------------------------------------------------------
	/**
	 * Send a {@link #ERROR} log message and log the exception.
	 * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
	 * @param message The message you would like logged.
	 * @param throwable An exception to log
	 */
	public static void e(String tag, String message, Throwable throwable) {
		if(BuildConfig.DEBUG) {
			tag = LOG_TAG_BASE + tag + "." + getMethodName();
			Log.e(tag, message, throwable);
		}
	}

	/**
	 * Get the method name for a depth in call stack. <br />
	 * Utility function
	 * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
	 * @return method name
	 */
	public static String getMethodName()
	{
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[4].getMethodName();
	}
}
