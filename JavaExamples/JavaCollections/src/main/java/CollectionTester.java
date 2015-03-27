import java.util.*;
/**
 * Created by joshika on 9/30/2014.
 */
public class CollectionTester {

    public static void list()
    {
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);
    }
    public static void collection(){
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        Set s1 = new HashSet();
        s1.add("Zara");
        s1.add("Mahnaz");
        s1.add("Ayan");
        System.out.println();
        System.out.println(" Set Elements");
        System.out.print("\t" + s1);

        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Daisy", "14");
        m1.put("Ayan", "12");

        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);

    }

    public static void main(String[] args) {
        tryCollection();
        System.out.println("Print list");
        list();
        System.out.println();
        System.out.println("Collection impl of all");
        collection();
    }
    public static void printColl(Collection coll)
    {
        System.out.println("Print Collection");
        System.out.print("\t" + coll);

    }
    public static void tryCollection()
    {
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        a1.add("byan");
        a1.add("cyan");
        a1.add("dyan");

        List a2 = new ArrayList();
        printColl(a1);

        a1.remove("dyan");
        a2.add("zara");
        a2.add("Mahnaz");

        a1.removeAll(a2);
        String[] a3 = new String[5];
        a1.toArray(a3);
        printColl(a1);
    }

    //@When("^quick create Lineage and VersionedFile with xdio and translation payload$")
/*
    public void quickPostVersionedFilesWith_Xlation_Xdio(String payloadfileName, String fileName) throws Exception
    {
        AddVersionedFileRequest request = new AddVersionedFileRequest();
        Collection<VersionedFileAndLineage> fileAndLineages = new ArrayList<>();

        Lineage lineage = new Lineage();
        lineage.setTempUrn("tempLineageUrn");
        lineage.setProperties(new HashMap<String, PropertyValue>());

        VersionedFile vf = new VersionedFile();
        vf.setName(fileName);
        vf.setVersionNumber((long)1);
        vf.setTempUrn("tempVersionUrn1");
        vf.setStorageType(StorageType.OSS);
        String payload = ConfigurationUtil.readAllLines("xdio.txt");
        vf.setTranslationPayload(payload);
        lineage.setXdioPayload(payload);
        vf.setProperties(new HashMap<String, PropertyValue>());
        VersionedFileAndLineage vl = new VersionedFileAndLineage();
        vl.setLineage(lineage);
        vl.setVersionedFile(vf);

        fileAndLineages.add(vl);

        request.setVersionsAndLineages(fileAndLineages);
        request.setRelationships(new ArrayList<Relationship>());
        request.setCopyRelationships(false);

        VersionedFileDetail response = CukeUtil.invokePost(
                BASE_URI + "/versionedfiles", VersionedFileDetail.class,
                request,
                fetchWipDmConsumerKey(),
                fetchWipDmConsumerSecret(),
                client, consumerToken, authToken);

        if (response != null && response.getLineageAndVersions() != null) {
            for (VersionedFileAndLineage verlin : response.getLineageAndVersions()) {
                cumulativeState.putVersionedFileAndLineage(verlin);
            }
        }
    }


    public void quickImportZip() throws Throwable {
        AddVersionedFileRequest request = new AddVersionedFileRequest();
        Collection<VersionedFileAndLineage> fileAndLineages = new ArrayList<>();

        Lineage lineage = new Lineage();
        lineage.setTempUrn("tempLineageUrn");
        lineage.setProperties(new HashMap<String, PropertyValue>());

        VersionedFile vf = new VersionedFile();
        vf.setName("assembly.iam.zip");
        vf.setVersionNumber((long)1);
        vf.setTempUrn("tempVersionUrn1");
        vf.setStorageType(StorageType.OSS);
        // byte[] encoded = Files.readAllBytes(Paths.get("j:\\f360\\upload\\payloads\\xlation.txt"));
        // String traslnPayload = new String(encoded);
        String payload = ConfigurationUtil.readAllLines("xdio.txt");
        vf.setTranslationPayload(payload);
        lineage.setXdioPayload(payload);
        vf.setProperties(new HashMap<String, PropertyValue>());
        VersionedFileAndLineage vl = new VersionedFileAndLineage();
        vl.setLineage(lineage);
        vl.setVersionedFile(vf);

        fileAndLineages.add(vl);

        request.setVersionsAndLineages(fileAndLineages);
        request.setRelationships(new ArrayList<Relationship>());
        request.setCopyRelationships(false);

        VersionedFileDetail response = CukeUtil.invokePost(
                BASE_URI + "/versionedfiles", VersionedFileDetail.class,
                request,
                fetchWipDmConsumerKey(),
                fetchWipDmConsumerSecret(),
                client, consumerToken, authToken);


        String uploadAuth = null;
        List<String> verFileUrns = new ArrayList<>();
        if (response != null && response.getLineageAndVersions() != null) {
            for (VersionedFileAndLineage verlin : response.getLineageAndVersions()) {
                uploadAuth = verlin.getVersionedFile().getUploadAuthorization();

                uploadToOss("assembly.iam.zip", verlin.getVersionedFile().getStorageUrn(), uploadAuth );
                verFileUrns.add(verlin.getVersionedFile().getUrn());
                cumulativeState.putVersionedFileAndLineage(verlin);
            }
        }
        ImportRequest impReq = new ImportRequest();

        impReq.setUrns(verFileUrns);
        impReq.setExtractReferences(false);
        impReq.setDestructive(true);
        impReq.setGenerateAssociations(false);
        //        defaultServiceLogin();
        ImportDetail impRes = CukeUtil.invokePost(
                BASE_URI + "/import", ImportDetail.class,
                impReq,
                fetchWipDmConsumerKey(),
                fetchWipDmConsumerSecret(),
                client, consumerToken, authToken);

        Map<String, PropertyValue> propVal = null;
        if (impRes != null && impRes.getVersionsAndLineages() != null) {
            for (VersionedFileAndLineage verlin2 : impRes.getVersionsAndLineages()) {
                //call translation service with scope id and get translated resource urn

                JSONObject transRes = null;
                propVal = verlin2.getVersionedFile().getProperties();
                if (propVal.containsKey("translationScopeId")) {
                    String scopeId = propVal.get("translationScopeId").getValue();
                    defaultOxygenLogin();

                    String ossurn = null;
                    int retry = 0;
                    while(ossurn==null && retry <  3) {
                        transRes = CukeUtil.invokeGet(
                                "https://translation-staging.api.autodesk.com/data/v1/" + scopeId, JSONObject.class,
                                fetchWipDmConsumerKey(),
                                fetchWipDmConsumerSecret(),
                                client, consumerToken, authToken);

                        ossurn = getOSSUrnFromJSON(transRes);
                        Thread.sleep(3000);
                        transRes = null;
                    }
                    assertNotNull(ossurn);
                    //  UriBuilder uri = UriBuilder.fromPath(BASE_URI + "/versionedfiles" + verlin2.getVersionedFile().getUrn());

                    // uri = uri.queryParam("requestDownloadAuthorization");
                    defaultServiceLogin();
                    TranslationCompleteRequest transComReq = new TranslationCompleteRequest();
                    TranslationResult transResult = new TranslationResult();
                    transResult.setVersionedFileUrn(verlin2.getVersionedFile().getUrn());
                    transResult.setSuccessful(true);
                    transResult.setTranslatedResourceUrn(ossurn);
                    transComReq.setTranslationResults(new ArrayList<TranslationResult>());
                    transComReq.getTranslationResults().add(transResult);

                    CukeUtil.invokePost(
                            BASE_URI + "/translationcomplete", void.class,
                            transComReq,
                            fetchWipDmConsumerKey(),
                            fetchWipDmConsumerSecret(),
                            client, consumerToken, authToken);
                }
                cumulativeState.putVersionedFileAndLineage(verlin2);
            }
        }

        responseState = new StateManager(response);
        requestState = null;

        /*/
/*************************
    }
*/

}
