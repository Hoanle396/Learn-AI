import pyautogui
import pyperclip
import time

time.sleep(2)
for i in range(100):
    pyperclip.copy(str(i+1) + " hi")
    pyautogui.hotkey("ctrl", "v")
    pyautogui.press("enter")
    time.sleep(0)
