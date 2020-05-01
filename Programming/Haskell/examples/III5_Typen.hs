len :: [a] -> Int
len []      = 0
len (x : xs)    = 1 + len xs

ident :: a -> a
ident x = x

app :: [a] -> [a] -> [a]
app []          ys  = ys
app (x : xs)    ys  = x : app xs ys

data Color  = Red | Yellow | Green deriving Show

ampel :: Color -> Color
ampel Red   = Green
ampel Green = Yellow
ampel _     = Red


data MyBool = Wahr | Falsch deriving Show

und :: MyBool -> MyBool -> MyBool
und Wahr  y = y
und _     _ = Falsch

data Nats = Zero | Succ Nats deriving Show

plus :: Nats -> Nats -> Nats
plus Zero       y   = y
plus (Succ x)   y   = Succ (plus x y)

half :: Nats -> Nats
half Zero            = Zero
half (Succ Zero)     =  Zero
half (Succ (Succ x)) = Succ (half x)

data List a = Nil | Cons a (List a) deriving Show

leng :: List a -> Int
leng Nil         = 0
leng (Cons x xs) = 1 + leng xs

append :: List a -> List a -> List a
append Nil         ys  = ys
append (Cons x xs) ys  = Cons x (append xs ys)
