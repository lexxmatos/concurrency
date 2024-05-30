package com.lexmatos.problems;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.Set;

public class AclPosixTest {
  public static void main(String[] args) throws IOException {
    Path filePath = Paths.get("testWriteRead.txt");
    changeTempDirPermissions(filePath);
  }

  private static void changeTempDirPermissions(Path tempDir) throws IOException {
    // Get the UserPrincipal for the current user
    UserPrincipalLookupService lookupService = tempDir.getFileSystem().getUserPrincipalLookupService();
    System.out.println("User: "+System.getProperty("user.name"));
    UserPrincipal currentUser = lookupService.lookupPrincipalByName(System.getProperty("user.name"));

    // Create a new ACL entry to grant full control to the current user
    AclEntry fullControlEntry = AclEntry.newBuilder()
      .setType(AclEntryType.ALLOW)
      .setPrincipal(currentUser)
      .setPermissions(AclEntryPermission.READ_DATA,
        AclEntryPermission.READ_ATTRIBUTES,
        AclEntryPermission.READ_NAMED_ATTRS,
        AclEntryPermission.DELETE_CHILD,
        AclEntryPermission.DELETE,
        AclEntryPermission.READ_ACL,
        AclEntryPermission.SYNCHRONIZE)
      .build();

    // Get the ACL file attribute view and modify ACL entries
    try {
      System.out.println("ACL view supported:" + Files.getFileStore(tempDir).supportsFileAttributeView(AclFileAttributeView.class));
      AclFileAttributeView aclView = Files.getFileAttributeView(tempDir, AclFileAttributeView.class);
      if (aclView != null) {
        System.out.println("ACL view supported.");
        aclView.setAcl(List.of(fullControlEntry));
      } else {
        System.out.println("ACL view not supported for the file system or file.");
        System.out.println("Trying use a POSIX.");
        Set<String> supportedViews = FileSystems.getDefault().supportedFileAttributeViews();
        if (supportedViews.contains("posix")) {
          System.out.println("POSIX file permissions are supported.");
          Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("r-xr-xr-x");
          Files.setPosixFilePermissions(tempDir, permissions);
          System.out.println("Permissions granted!");
        } else {
          System.out.println("POSIX file permissions are not supported.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
