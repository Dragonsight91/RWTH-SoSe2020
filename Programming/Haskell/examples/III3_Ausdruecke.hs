maxi :: (Int, Int) -> Int
maxi (x, y) = if x >= y then x else y

roots :: Float -> Float -> Float -> (Float, Float)
roots a b c = let d = sqrt (b*b - 4*a*c)
                  e = 2*a
              in((-b - d)/e, (-b + d)/e)

suc :: Int -> Int
suc = \x -> x + 1

double :: Int -> Int
double = \x -> 2 * x

plus1 :: (Int, Int) -> Int
plus1 = \(x,y) -> x + y

plus :: Int -> Int -> Int
plus x = \y -> x + y