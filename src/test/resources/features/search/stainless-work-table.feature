Feature: Search product by name

#During testing it was discovered that there was a product
#on 9th page of the results, that didn't have th word "Table" in the name.
#This was making the test fail during the validation step.
#I decied to break out test case into three different scenarios
#1. Purely focus on validating that every search result on every page contains the desired word.
#2. Purely focus on navigating to last page and adding the last product to cart.
#3. The original scenario, where we validate each result on each page and then adding the last product to cart

  @StainlessWorkTable
  Scenario: Verify search results contain word 'table'
    Given Artem is looking for new product to buy
    When they looks up "stainless work table"
    Then they should see a list of products containing "table"

  @StainlessWorkTable
  Scenario: Adding last search result for 'stainless work table' to cart
    Given Evgeniy is looking for new product to buy
    When they looks up "stainless work table"
    Then they should add last search result for "saintless work table" to cart
    And they should empty the cart

  @StainlessWorkTable
  Scenario: Verify search results and add last product to cart
    Given Zina is looking for new product to buy
    When they looks up "stainless work table"
    Then they should see a list of products containing "table" adding the last product to cart
    And they should empty the cart
