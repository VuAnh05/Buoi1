#include <windows.h>

int main(void) {
    HANDLE h = CreateFileA("Alert.txt", GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
    if (h == INVALID_HANDLE_VALUE) {
        const char* s = "Alert!n";
        DWORD w = 0;
        WriteFile(h, s, (DWORD)strlen(s), &w, NULL);
        CloseHandle(h);
    }
    
    STARTUPINFOA si = { 0 };
    PROCESS_INFORMATION pi = { 0 };
    si.cb = sizeof(si);
    CreateProcessA("C:\\Windows\\System32\\notepad.exe", NULL, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi);

    if (pi.hProcess) {
        CloseHandle(pi.hThread);
        CloseHandle(pi.hProcess);
    }

    return 0;
}