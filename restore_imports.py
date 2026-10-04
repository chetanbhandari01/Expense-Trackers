import os
import glob

def restore_imports():
    project_root = r"C:/Users/Chetan/StudioProjects/expensemanager"
    files = glob.glob(f"{project_root}/**/*.kt", recursive=True) + glob.glob(f"{project_root}/**/*.kts", recursive=True) + glob.glob(f"{project_root}/**/*.toml", recursive=True)

    count = 0
    for file_path in files:
        if os.path.isfile(file_path):
            with open(file_path, "r", encoding="utf-8") as f:
                content = f.read()

            new_content = content

            # Restore designsystem dependency import
            new_content = new_content.replace('com.chetanbhandari.designsystem', 'com.naveenapps.designsystem')
            # Restore settings dependency import
            new_content = new_content.replace('com.chetanbhandari.settings', 'com.naveenapps.settings')

            # Restore gradle plugin identifiers in .kts files
            if file_path.endswith(".kts"):
                new_content = new_content.replace('chetanbhandari.plugin.', 'naveenapps.plugin.')
                new_content = new_content.replace('chetanbhandari.android.', 'naveenapps.android.')
                new_content = new_content.replace('chetanbhandari.di', 'naveenapps.di')
                new_content = new_content.replace('chetanbhandari.jvm', 'naveenapps.jvm')
                new_content = new_content.replace('id("chetanbhandari.', 'id("naveenapps.')
                new_content = new_content.replace('id = "chetanbhandari.', 'id = "naveenapps.')

            if file_path.endswith(".toml"):
                new_content = new_content.replace('chetanbhandari.plugin.', 'naveenapps.plugin.')
                new_content = new_content.replace('chetanbhandari.android.', 'naveenapps.android.')
                new_content = new_content.replace('chetanbhandari.di', 'naveenapps.di')
                new_content = new_content.replace('chetanbhandari.jvm', 'naveenapps.jvm')
                new_content = new_content.replace('com.chetanbhandari:designsystem', 'com.naveenapps:designsystem')
                new_content = new_content.replace('com.chetanbhandari:settings', 'com.naveenapps:settings')

            if new_content != content:
                with open(file_path, "w", encoding="utf-8") as f:
                    f.write(new_content)
                count += 1

    print(f"Restored imports/plugins in {count} files.")

if __name__ == "__main__":
    restore_imports()
