print "This demo 6: hello Kaosiung"

def adder(a, b):
    """help you to solve difficult math problem ..
    >>> adder(1,2)
    3
    """
    return a + b


if __name__ == "__main__":
    import doctest
    doctest.testmod()
