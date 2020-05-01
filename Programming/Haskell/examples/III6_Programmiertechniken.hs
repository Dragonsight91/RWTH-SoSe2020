import Data.Char (isLower)

comp :: (b -> c) -> (a -> b) -> (a -> c)
comp f g = \x -> f (g x)

half :: Int -> Int
half 0 = 0
half 1 = 0
half x = 1 + half (x-2)

square :: Int -> Int
square x = x * x

plus1 :: (Int, Int) -> Int
plus1 (x, y) = x + y

plus :: Int -> Int -> Int
plus x y = x + y

suc :: Int -> Int
suc = plus 1

curry' :: ((a,b) -> c) -> a -> b -> c
curry' f = g 
          where g x y = f (x,y)

uncurry' :: (a -> b -> c) -> (a,b) -> c
uncurry' g = f 
          where f (x,y) = g x y

suclist :: [Int] -> [Int]
suclist []      = []
suclist (x:xs)  = suc x : suclist xs

sqrtlist :: [Float] -> [Float]
sqrtlist []         = []
sqrtlist (x:xs)     = sqrt x : sqrtlist xs

map' :: (a -> b) -> [a] -> [b]
map' g []       = []
map' g (x:xs)   = g x : map' g xs

suclist' :: [Int] -> [Int]
suclist' = map suc

sqrtlist' :: [Float] -> [Float]
sqrtlist' = map sqrt

dropEven :: [Int] -> [Int]
dropEven [] = []
dropEven (x:xs) | odd x     = x : dropEven xs
                | otherwise = dropEven xs

dropUpper :: [Char] -> [Char]
dropUpper [] = []
dropUpper (x:xs) | isLower x = x : dropUpper xs
                 | otherwise = dropUpper xs


filter' :: (a -> Bool) -> [a] -> [a]
filter' g [] = []
filter' g (x:xs) | g x       = x : filter' g  xs
                 | otherwise = filter' g xs

dropEven' :: [Int] -> [Int]
dropEven' = filter odd

dropUpper' :: [Char] -> [Char]
dropUpper' = filter isLower

from :: Int -> [Int]
from x = x : from (x+1)

take' :: Int -> [a] -> [a]
take' 0    _   = []
take' n (x:xs) = x : take' (n-1) xs

drop_mult :: Int -> [Int] -> [Int]
drop_mult x xs = filter (\y -> mod y x /= 0) xs

dropall :: [Int] -> [Int]
dropall (x:xs) = x : dropall (drop_mult x xs)

primes :: [Int]
primes = dropall (from 2)
