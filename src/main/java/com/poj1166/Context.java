package com.poj1166;

public enum Context {
	Case1{
		public void strategy(){
			
		}
	},
	Case2{
		public void strategy(){
			
		}
	},
	Case3{
		public void strategy(){
			
		}
	},
	Case4{
		public void strategy(){
			
		}
	},
	Case5{
		public void strategy(){
			
		}
	},
	Case6{
		public void strategy(){
			
		}
	},
	Case7{
		public void strategy(){
			
		}
	},
	Case8{
		public void strategy(){
			
		}
	},
	Case9{
		public void strategy(){
			
		}
	};
	
	private int[] a;
	private Context(){
		
	}
	private Context(int[] a){
		this.a=a;
	}
	public  abstract void strategy();
}
