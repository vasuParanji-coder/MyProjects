public void addReview(ProductReview prodReview)
{
   reviewList.add(prodReview);
   String prodName = prodReview.getName();
   for(int i = 0; i < productList.size(); i++)
   {
      if(!productList.get(i).equals(prodName))
      {
         productList.add(prodName);
      }
   }
}


public int getGoodNumReviews(String prodName)
{
   int goodReviewCount = 0;
   for(int i = 0; i < reviewList.size(); i++)
   {
      if(reviewList.get(i).getName() == prodName && 
      reviewList.get(i).getReview().contains("best"))
      {
         goodReviewCount++;
      }
   }
   return goodReviewCount;
}

/*
public ArrayList<ProductReview> getBestReviewsByProduct(String prodName)
A local arraylist is declared in the new method to store the reviews-
"ArrayList<ProductReview> bestReviews"
The for loop in getGoodNumReviews can be retained
The local count is not needed
In the if condition, instead of incrementing the count variable
add the review to the local arrayList
Then return the local ArrayList once the for loop ends
*/