def capital_case(x):
    return x.capitalize()

def test_capital_case_pass():
    assert capital_case('semaphore') == 'Semaphore'

# def test_capital_case_fail():
#     assert capital_case('semaphore') == 'semaphore'