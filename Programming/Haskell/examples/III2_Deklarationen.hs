len :: [Int] -> Int
len []        =   0
len (x : xs)  =   1 + len xs

square :: Int -> Int
square x = x * x

one :: Int
one = 1

three :: Int -> Int
three x = 3

non_term :: Int -> Int
non_term x = non_term (x+1)

maxi :: (Int, Int) -> Int
maxi (x, y) | x >= y    = x
            | otherwise = y

-- Erste Version von plus
plus1 :: (Int, Int) -> Int
plus1 (x, y) = x + y

{- 2. Version von plus
Diese Version werden wir im folgenden benutzen.-}
plus :: Int -> Int -> Int
plus x y = x + y

suc :: Int -> Int
suc = plus 1

und1 :: Bool -> Bool -> Bool
und1 True  y = y
und1 False y = False

und :: Bool -> Bool -> Bool
und True  y = y
und x y = False

unclear :: Bool
unclear = not unclear

second :: [Int] -> Int
second []           = 0
second [x]          = 0
second (x : y : xs) = y


roots1 :: Float -> Float -> Float -> (Float, Float)
roots1 a b c = ((-b - d)/e, (-b + d)/e)
              where {d = sqrt (b*b - 4*a*c);
                     e = 2*a}

roots :: Float -> Float -> Float -> (Float, Float)
roots a b c = ((-b - d)/e, (-b + d)/e)
              where d = sqrt (b*b - 4*a*c)
                    e = 2*a
