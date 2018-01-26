package com.wei.springboottucao.cache;

public class GlobalCache {
	
	private static GlobalCache m_Cache;
	
	private ThreadLocal<Cache> local = new ThreadLocal<Cache>();
	
	private GlobalCache(){
		
	}
	
	public static GlobalCache getInstance(){
		if(m_Cache == null){
			synchronized(GlobalCache.class){
				if(m_Cache == null){
					m_Cache = new GlobalCache();
				}
			}
		}
		return m_Cache;
	}
	
	public void addCache(Cache oCache){
		this.local.set(oCache);	
	}
	
	public Cache getCache(){
		return this.local.get();
	}
	
	public static class Cache {
		
		private String clientId;

		public String getClientId() {
			return clientId;
		}

		public void setClientId(String clientId) {
			this.clientId = clientId;
		}
		
	}
	
}
