app :: [Int] -> [Int] -> [Int]
app []      ys  = ys
app (x : xs)    ys  = x : app xs ys

und :: Bool -> Bool -> Bool
und True  y = y
und _     _ = False


has_length_three :: [Int] -> Bool
has_length_three [x,y,z] = True
has_length_three _       = False


maxi :: (Int, Int) -> Int
maxi (0, y)     = y
maxi (x, 0)     = x
maxi (x, y)     = 1 + maxi (x-1, y-1)
