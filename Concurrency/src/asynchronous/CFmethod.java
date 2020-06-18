package asynchronous;

import java.util.concurrent.CompletableFuture;

// CompletableFuture Method 
public class CFmethod {

	public static void main(String[] args) {
		// supplyAsync
		CompletableFuture<Integer> cf1= CompletableFuture.supplyAsync(()-> myMethod());
		
		// thenApply
		//CompletableFuture cf2= cf1.thenApply(e -> e+1);
		CompletableFuture cf2= cf1.thenApply(e -> e/0);
		
		// thenAccept
		CompletableFuture cf3 = cf2.thenAccept(e -> System.out.println(e));
		
		//ThenRun
		cf3.thenRun(() -> System.out.println("Executed Successfully"));
		
		//Exceptionally
		
		//CompleteExceptionally
		if(true)
			cf2.completeExceptionally(new RuntimeException("Value is wrong"));
		
		//isCompletedExceptionally
		System.out.println("isCompletedExceptionally "+cf2.isCompletedExceptionally());
		
		// ThenCompose
		cf2.thenCompose(data -> data).thenAccept(e -> System.out.println(e));
		
	}

	private static int myMethod() {
		// TODO Auto-generated method stub
		return 15;
	}

}
